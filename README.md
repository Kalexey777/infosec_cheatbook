# infosec_cheatbook

# GDB
https://habr.com/en/articles/535960/ - gdb usage

https://www.brendangregg.com/blog/2016-08-09/gdb-example-ncurses.html

# APK
## Тулзы
https://habr.com/en/articles/780694/ - apk reverse\
jadx - decompile .dex to java\
apkstudio - disassemble apk, edit .smali, build .apk, sign and install it\
Может быть полезно прокинуть с телефона прокси в burp suite и сниффить трафик, если приложение требует доступа к интернету.\
Лучше НЕ использовать android studio для эмуляции андроида, по крайней мере у меня(Василия), она работала очень плохо. Проще взять андроид телефон и на нём тестировать пропатченное приложение. Логи можно читать через ```adb logcat```, или его цветные версии. \
```pm list packages``` выведет список установленных приложений, где можно будет найти наше приложение и его искать в логах
## Примеры заданий
Tinkoff CTF - есть демо задания с разборами, на которых можно отработать разные техники, есть просто задания прошлых лет\
НТО - здесь должна быть ссылка на репозиторий 2 этапа 2023 года. На 1 этапе тоже был реверс в категории ppc, его тоже хорошо бы найти

# Python reverse
## Тулзы
https://github.com/extremecoders-re/pyinstxtractor
[pycdc](https://github.com/zrax/pycdc)
## Примеры заданий
https://github.com/D13David/ctf-writeups/blob/main/osctf24/rev/another_python_game/README.md

# IDA
https://habr.com/en/companies/angarasecurity/articles/777648/ - IDA Free usage

# r2
https://github.com/radareorg/radare2/blob/master/doc/intro.md

https://book.rada.re/

# ALL_IN_ONE
https://habr.com/en/companies/dsec/articles/334832/

# Samba
https://www.zdnet.com/article/how-to-share-folders-to-your-network-from-linux/
https://library.mosse-institute.com/articles/2022/06/linux-exploitation-format-string-vulnerabilities-and-exploitation/linux-exploitation-format-string-vulnerabilities-and-exploitation.html
