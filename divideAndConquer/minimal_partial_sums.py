#! /usr/bin/env python3


def calc_sums(a, l, r):
    sum = 0
    for i in a[l : (r + 1)]:
        sum += i
    return sum


def sums(a):
    m = int(len(a) / 2)

    if len(a) == 1:
        return (0, 0)
    if len(a) == 2:
        ls = a[0]
        rs = a[1]
        lrs = ls + rs
        if ls < lrs:
            return (0, 0)
        if rs < lrs:
            return (1, 1)
        return (0, 1)

    (ll, lr) = sums(a[0:m])
    (rl, rr) = sums(a[m : (len(a) - 1)])
    rl += m
    rr += m

    ls = calc_sums(a, ll, lr)
    rs = calc_sums(a, rl, rr)
    s = calc_sums(a, ll, rr)

    if ls < s and rs > ls:
        return (ll, lr)
    if rs < s:
        return (rl, rr)
    return (ll, rr)


print(sums([1, 3, -4, -6, 3, -10, 1, -2, 19, -10]))
