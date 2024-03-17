FROM ubuntu:18.04

RUN apt-get update && apt-get -y install socat
RUN adduser guest
RUN echo guest:guest | chpasswd
RUN adduser examplesecretguy
RUN echo examplesecretguy:EXAMPLESECRETPASSWORD | chpasswd

RUN echo spbctf{*********************} > /flag.txt
RUN chown examplesecretguy:examplesecretguy /flag.txt
RUN chmod 0400 /flag.txt

ADD task /task
RUN chmod 0755 /task
EXPOSE 8080

ENTRYPOINT socat tcp-l:8080,reuseaddr,fork "system:/task 2>&1"
