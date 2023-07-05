#! /usr/bin/env python3

from functools import reduce


# Größter gemeinsamer Teiler aka greatest common divisor
def ggt(a, b):
    m = a % b

    if m == 0:
        return b

    return ggt(b, m)


assert ggt(132, 28) == 4

# For lists of values, you can either use reduce or a manual method using a for-loop
# print(reduce(ggt, (132, 28, 4, 8, 24)))
#
l = [132, 28, 4, 8, 24]
t = ggt(l[0], l[1])

for i in l[2:]:
    t = ggt(i, t)

print(t)
