from pwn import *

s_hex = "_   _"
s_octal = "___         _           _"
s_bigendian64 = "____   _          _____             _  _                 __    _  _"
s_littleendian64 = "_      _  _    _    _         _____             _  _                 __    _  _"
a = [s_hex, s_octal, s_bigendian64, s_littleendian64]

proc = remote("109.233.56.90", 11573)
s1 = proc.recvline()
s2 = proc.recvline().decode().strip()
proc.recvline()
proc.recvline()
proc.recvline()
proc.recvline()
proc.recvline()
while (s2 in a):
    if s2 == s_hex:
        proc.sendline(hex(int(s1.split()[1]))[2:])
        print("sending hex")
    if s2 == s_octal:
        proc.sendline(oct(int(s1.split()[1]))[2:])
        print("sending oct")
    if s2 == s_bigendian64:
        proc.sendline(p64(int(s1.split()[1]), endian="big"))
        print("sending be64")
    if s2 == s_littleendian64:
        proc.sendline(p64(int(s1.split()[1]), endian="little"))
        print("sending le64")
    proc.recvline()
    s1 = proc.recvline()
    print(s1)
    s2 = proc.recvline().decode().strip()
    print(s2)
    print(proc.recvline())
    print(proc.recvline())
    print(proc.recvline())
    print(proc.recvline())
    print(proc.recvline())




proc.interactive()
