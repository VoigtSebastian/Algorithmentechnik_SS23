#! /usr/bin/env python3


# Größter gemeinsamer Teiler aka greatest common divisor
def ggt(a, b):
    m = a % b

    if m == 0:
        return b

    return ggt(b, m)


assert ggt(132, 28) == 4
