package com.crimzoncode.tqcontests.data.model;

import android.text.TextUtils;
import com.crimzoncode.tqcontests.util.HelperFns;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question extends BaseModel implements Serializable {
    @SerializedName("correct_options")
    public String correctOption;
    @SerializedName("option_display_strategy")
    public String displayStrategy;
    public int id;
    public String imageUrl;
    @SerializedName("marks")
    public int marks;
    @SerializedName("options")
    public ArrayList<Option> options = new ArrayList<>();
    @SerializedName("num_options")
    public int optionsCount;
    @SerializedName("question_text")
    public Object question;
    @SerializedName("question_num")
    public int questionNum;
    public long timeSpent;
    public String userOption;
    public int userOptionIdx;

    public String getCorrectOption() {
        return this.correctOption;
    }

    public int getCorrectOptionIdx() {
        for (int i = 0; i < this.options.size(); i++) {
            if (this.options.get(i).getOptionCode().equalsIgnoreCase(this.correctOption)) {
                return i;
            }
        }
        return -1;
    }

    public int getId() {
        return this.id;
    }

    public int getMarks() {
        if (this.marks == 0) {
            this.marks = 1;
        }
        return this.marks;
    }

    public List<Option> getOptions() {
        return this.options;
    }

    public int getQuestionNum() {
        return this.questionNum;
    }

    public int getTimeSpent() {
        return (int) this.timeSpent;
    }

    public String getUserOption() {
        return this.userOption;
    }

    public boolean isAnswerCorrect() {
        return this.userOption.equals(this.correctOption);
    }

    public boolean isCorrectAnswerAvailable() {
        return !TextUtils.isEmpty(this.correctOption);
    }

    public void setCorrectOption(String str) {
        this.correctOption = str;
    }

    public void setTimeSpent(long j) {
        this.timeSpent = j;
    }

    public void setUserOption(String str) {
        for (int i = 0; i < this.options.size(); i++) {
            if (this.options.get(i).getOptionCode().equalsIgnoreCase(str)) {
                this.userOptionIdx = i;
            }
        }
        this.userOption = str;
    }

    public void setUserOptionIdx(int i) {
        this.userOptionIdx = i;
        this.userOption = this.options.get(i).getOptionCode();
    }

    public String toString() {
        return HelperFns.getGson().toJson((Object) this);
    }
}
