#! /usr/bin/env python3


def inverted_power(x, m):
    if m == 0:
        return 1
    if m == 1:
        return 1 / x

    l = m // 2
    r = m - l

    return inverted_power(x, l) * inverted_power(x, r)


x = 2
m = 5
print(1 / (x**m))
print(inverted_power(x, m))
