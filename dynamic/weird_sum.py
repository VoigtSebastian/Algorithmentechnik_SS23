#! /usr/bin/env python3


def sum(n):
    b = [0] * (n + 1)
    b[0] = 4

    for i in range(1, n + 1):
        for j in range(0, i):
            b[i] += 1 + b[j] + b[i - j - 1]
        b[i] *= 1 / i

    print(b)
    return b[n]


print(sum(10))
