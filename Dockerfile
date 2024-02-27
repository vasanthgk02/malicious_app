FROM ubuntu

COPY . /application

WORKDIR /application/backend

RUN apt-get update && apt-get install -y python3 python3-pip && apt-get install default-jdk -y
RUN pip3 install -r requirements.txt
RUN java -version

LABEL icon=/application/other/images/android.png

EXPOSE 5000
CMD [ "flask", "run","--host","0.0.0.0","--port","5000"]