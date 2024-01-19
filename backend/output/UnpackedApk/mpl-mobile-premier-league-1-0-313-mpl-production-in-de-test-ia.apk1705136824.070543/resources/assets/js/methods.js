var converter;
var quiz
var quizMode;
var userObjects;
var userAttempts;
var currentQuestionIdx;
var numImages = 0;
var loadedImagesCounter = 0;
var $slides;

function jbSetQuiz(params) {
    quiz = params['quiz'];
    quizMode = params['quizMode'];

    converter = converter || new showdown.Converter({
        tables: true
    });

    var $quizContainer = $('#quizContainer');

    for (var questionIdx = 0, len = quiz['questions'].length; questionIdx < len; questionIdx++) {
        var questionHtml = __getQuestionHtml(quiz['questions'][questionIdx], questionIdx);
        $quizContainer.append(questionHtml)
        imgs = $(questionHtml).find("img")
        for(i=0; i<imgs.length; i++) {
            imgs[i].addEventListener("load", incrementImagesCounter, false);
            imgs[i].addEventListener("error", imageFailedToLoad, false);
        }
    }
    MathJax.Hub.Queue(['Typeset', MathJax.Hub]);

    switch (quizMode) {
        case 'QUIZ':
            __setQuizMode();
            break;

        case 'REVIEW':
            __setReviewMode();
            break;

        case 'CHALLENGE':
            __setQuizMode();
            break;
    }

    $slides = $('#quizContainer').find('.questionMainContainer');
    $slides.hide();

    numImages = $("img").length;
    currentQuestionIdx = 0;
    androidJsInterface.javaQuizLoadCompleted();
    if (numImages == 0) {
        androidJsInterface.javaAllImagesLoaded();
    }
}

function __setReviewMode() {
    $('#quizContainer').find('.optionButton').attr('disabled', 'disabled');
    $('#quizContainer').find('.optionButton').css('background', '#9e9e9e');
    $('#quizContainer').find('.optionButton').css('border', '4px solid #9e9e9e');
    var options = $('#quizContainer').find('.optionButton');
    options.each(function(index) {
        var questionIdx = $(options[index]).data('question-idx');
        var optionIdx = $(options[index]).data('option-idx');
        var optionCodex = $(options[index]).data('option-codex');
        var correctOption = quiz.questions[questionIdx].correct_options;

        if (optionCodex == correctOption) {
            var optionParams = {
                'questionIdx': questionIdx,
                'optionIdx': optionIdx,
                'status': 'CORRECT'
            };
            jbUpdateOptionStatus(optionParams);
        }
    });
}

function __setQuizMode() {
    $('#quizContainer').on('click', '.optionButton', function() {
        var $optionElement = $(this);
        var questionIdx = $optionElement.data('question-idx');
        var optionIdx = $optionElement.data('option-idx');
        submitUserOption(questionIdx, optionIdx);
    });

}

function jbSetAttemptDetails(params) {
    defaultUser = params["defaultUser"];
    attemptDataList = params["attemptDataList"];

    var options = $('#quizContainer').find('.optionButton');
    for (var i = attemptDataList.length - 1; i >= 0; i--) {

        options.each(function(index) {
            for (var j = attemptDataList[i]['attempt_details'].length - 1; j >= 0; j--) {
                var questionIdx = $(options[index]).data('question-idx');
                var optionIdx = $(options[index]).data('option-idx');
                var optionCodex = $(options[index]).data('option-codex');
                var correctOption = quiz.questions[questionIdx].correct_options;

                if (j == questionIdx && attemptDataList[i]['attempt_details'][j].options == optionCodex) {
                    //Showing wrong option when one attempt
                    if (quizMode == 'REVIEW') {
                        if (optionCodex != correctOption) {
                            var optionParams = {
                                'questionIdx': questionIdx,
                                'optionIdx': optionIdx,
                                'status': 'WRONG'
                            };
                            jbUpdateOptionStatus(optionParams);
                        }
                    }

                    //Showing user attempt when one to one attempts
                    if (quizMode == 'COMPARISON_REVIEW') {
                        var userParams = {
                            'firstName': attemptDataList[i]['user'].first_name,
                            'lastName': attemptDataList[i]['user'].last_name,
                            'profilePic': attemptDataList[i]['user'].profile_pic.thumb
                        }
                        if (attemptDataList.length > 1) {
                            if (attemptDataList[i]['user'].id == defaultUser) {
                                $(options[index]).before(__getProfilePic(userParams, "left"));
                            } else {
                                $(options[index]).before(__getProfilePic(userParams, "right"));
                            }
                        } else {
                            if (optionCodex != correctOption) {
                                var optionParams = {
                                    'questionIdx': questionIdx,
                                    'optionIdx': optionIdx,
                                    'status': 'WRONG'
                                };
                                jbUpdateOptionStatus(optionParams);
                            }
                        }
                    }

                    //Showing user attempt when one to many attempts
                    if (quizMode == 'STATS_REVIEW') {
                        if (attemptDataList[i]['user'].id == defaultUser) {
                            var userParams = {
                                'firstName': attemptDataList[i]['user'].first_name,
                                'lastName': attemptDataList[i]['user'].last_name,
                                'profilePic': attemptDataList[i]['user'].profile_pic.thumb
                            }
                            $(options[index]).before(__getProfilePic(userParams, "left"));

                            var userCount = quiz.questions[questionIdx].options[optionIdx].no_of_users - 1;
                            if (userCount > 0) {
                                $(options[index]).before(__getUserCountView({ 'count': userCount, 'optionText': quiz.questions[questionIdx].options[optionIdx].option_text, 'mine': true }));
                            }
                        }
                    }
                } else if (j == questionIdx) {
                    var userCount = quiz.questions[questionIdx].options[optionIdx].no_of_users;
                    if (quizMode == 'STATS_REVIEW' && userCount > 0 && attemptDataList[i]['attempt_details'][j].options != optionCodex) {
                        $(options[index]).before(__getUserCountView({ 'count': userCount, 'optionText': quiz.questions[questionIdx].options[optionIdx].option_text, 'mine': false }));
                    }
                }
            }
        });
    }
}

function __getShortName(params) {
    var firstName = params["firstName"];
    var lastName = params["lastName"];

    var shortName = !!lastName ? firstName.charAt(0) + lastName.charAt(0) : firstName.charAt(0);

    return shortName.toUpperCase();
}

function __getProfilePic(params, position) {
    var firstName = params["firstName"];
    var profilePic = params["profilePic"];
    var value;

    if (profilePic) {
        if (profilePic.indexOf("//") == 0) {
            profilePic = "https:" + profilePic;
        }
        value = "<img src='" + profilePic + "' height='100%' width='100%' style='border-radius: 100%;'>";
    } else if (firstName) {
        value = __getShortName(params);
    } else {
        value = "<img src='//img/profile_256.jpg' height='100%' width='100%' style='border-radius: 100%;'>";
    }

    var profilePic = "<div style='line-height: 2.75; font-weight: bold; font-size: 14px; text-align: center; background: #EE6004; color: #FFF; border-radius: 100%; width: 35px; height: 35px; box-shadow: 2px 2px 10px -8px; position: absolute; bottom: 0; " + position + ": 0;'>" + value + "</div>";

    return profilePic;
}

function __getUserCountView(params) {
    var count = params['count'];
    var userCountView = "<div style='line-height: 2.75; font-weight: bold; font-size: 14px; text-align: center; background: #EE6004; color: #FFF; border-radius: 100%; width: 35px; height: 35px; box-shadow: 2px 2px 10px -8px; position: absolute; bottom: 0; right: 0;'>+" + count + "</div>";
    return userCountView;
}

function __getQuestionHtml(question, questionIdx) {
    var questionTemplate = "<div class='questionMainContainer' id='questionMainContainer_{{questionIdx}}' data-question-idx='{{questionIdx}}'><div id ='questionContainer_{{questionIdx}}' class='questionContainer'>{{question}}</div><div id='optionsContainer_{{questionIdx}}' class='container'>{{options}}</div><div id='solutionContainer_{{questionIdx}}' class='container hide-me'>{{solution}}</div></div>";
    var questionHtml = converter.makeHtml(question['question_text']);

    var solutionHtml = "NA";
    if (question['solution'] != null && question['solution'] != "") {
        if (question['solution']['solution_text'] != "") {
            solutionHtml = converter.makeHtml(question['solution']['solution_text']);
        }
    }
    var optionsHtml = "";

    for (var optionIndex = 0; optionIndex < question['options'].length; optionIndex++) {
        optionsHtml = optionsHtml + __getOptionHtml(question['options'][optionIndex], questionIdx, optionIndex, question['options'][optionIndex].code)
    }
    var outputHtml = __render(questionTemplate, {
        'questionIdx': questionIdx,
        'question': questionHtml,
        'options': optionsHtml,
        'solution': solutionHtml
    });
    return outputHtml;
}

function __getOptionHtml(option, questionIdx, optionIdx, optionCodex) {
    var optionTemplate = "<div class='col' style='position: relative;'><button class='optionButton' id='optionButton_{{questionIdx}}_{{optionIdx}}' data-question-idx='{{questionIdx}}' data-option-idx='{{optionIdx}}' data-option-codex='{{optionCodex}}'>{{option}}</button></div>";
    var optionHtml = converter.makeHtml(option['option_text']);
    var outputHtml = __render(optionTemplate, {
        'questionIdx': questionIdx,
        'optionIdx': optionIdx,
        'optionCodex': optionCodex,
        'option': optionHtml
    });
    return outputHtml;
}

function __render(template, params) {
    var result = template;
    Object.keys(params).forEach(function(key) {
        var re = new RegExp('{{' + key + '}}', 'g');
        result = result.replace(re, params[key]);
    });
    return result;
}

function jbShowQuestionWithIdx(params) {
    var index = params['index'];
    var offset = params['offset'];

    var $slides = $('#quizContainer').find('.questionMainContainer');
    if (offset > 0) {
        $($slides[index - 1]).hide('slide', {
            direction: 'left'
        }, function() {
            $($slides[index - 1 + offset]).show('slide', {
                direction: 'right'
            }, function() {
                __questionTransitionComplete();
            })

        });
    } else {
        $($slides[index + 1]).hide('slide', {
            direction: 'right'
        }, function() {
            $($slides[index + 1 - offset]).show('slide', {
                direction: 'left'
            }, function() {
                __questionTransitionComplete();
            });

        });

    }
}

function jbMoveQuestion(params) {
    var offset = params['offset'];
    var $slides = $('#quizContainer').find('.questionMainContainer');

    if (offset > 0) {
        $($slides[currentQuestionIdx]).hide('slide', {
            direction: 'left'
        }, function() {
            currentQuestionIdx += offset;
            $($slides[currentQuestionIdx]).show('slide', {
                direction: 'right'
            }, function() {
                __questionTransitionComplete();
            })

        });
    } else {
        $($slides[currentQuestionIdx]).hide('slide', {
            direction: 'right'
        }, function() {
            currentQuestionIdx += offset
            $($slides[currentQuestionIdx]).show('slide', {
                direction: 'left'
            }, function() {
                __questionTransitionComplete();
            });

        });

    }
}

function jbShowSolutionByQuestionId(params) {
    var questionIdx = currentQuestionIdx;
    var $mainContainer = $('#questionMainContainer_' + questionIdx);
    var $questionContainer = $mainContainer.find('#questionContainer_' + questionIdx);
    var $optionsContainer = $mainContainer.find('#optionsContainer_' + questionIdx);
    var $solutionContainer = $mainContainer.find('#solutionContainer_' + questionIdx);
    $questionContainer.addClass('hide-me');
    $optionsContainer.addClass('hide-me');
    $solutionContainer.removeClass('hide-me');
}

function jbSwitchBackToQuestion(params) {
    var questionIdx = currentQuestionIdx;
    var $mainContainer = $('#questionMainContainer_' + questionIdx);
    var $questionContainer = $mainContainer.find('#questionContainer_' + questionIdx);
    var $optionsContainer = $mainContainer.find('#optionsContainer_' + questionIdx);
    var $solutionContainer = $mainContainer.find('#solutionContainer_' + questionIdx);
    $solutionContainer.addClass('hide-me');
    $questionContainer.removeClass('hide-me');
    $optionsContainer.removeClass('hide-me')
}

function __questionTransitionComplete() {
    if ('READ_ONLY' != quizMode) {
        $('#quizContainer').find('.optionButton').removeAttr('disabled');
    }
    MathJax.Hub.Queue(['Typeset', MathJax.Hub]);
    androidJsInterface.questionTransitionComplete();
}

function submitUserOption(questionIdx, optionIdx) {
    $('#quizContainer').find('.optionButton').attr('disabled', 'disabled');
    questionIdx = parseInt(questionIdx);
    optionIdx = parseInt(optionIdx);
    androidJsInterface.selectedOption(questionIdx, optionIdx);
}

function jbUpdateOptionStatus(params) {
    var questionIdx = params['questionIdx'];
    var optionIdx = params['optionIdx'];
    var status = params['status'];
    var background = '';
    switch (status) {
        case "CORRECT":
            background = '#006600';
            border = '4px solid #006600';
            break;
        case "WRONG":
            background = '#e60000';
            border = '4px solid #e60000';
            break;
        case "NORMAL":
            background = '#5A0ACF';
            border = '4px solid #ffd949';
            break;
    }

    $('#optionButton_' + questionIdx + '_' + optionIdx).css({
        'background': background,
        'color': '#fff',
        'font-weight': '600',
        'border':border
    });
}

function incrementImagesCounter() {
    loadedImagesCounter++;
    androidJsInterface.javaImageLoadingProgress(loadedImagesCounter, numImages);
    if(loadedImagesCounter == numImages) {
        androidJsInterface.javaAllImagesLoaded();
    }
}

function imageFailedToLoad() {
    loadedImagesCounter++;
    androidJsInterface.imageFailedToLoad(loadedImagesCounter, numImages);
    if(loadedImagesCounter == numImages) {
        androidJsInterface.javaAllImagesLoaded();
    }
}

function jbShowQuiz() {

    if ($slides.length > 0) {
        $($slides[0]).show();
    }
}
