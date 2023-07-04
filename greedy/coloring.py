#! /usr/bin/env python3


a = [[0, 1, 0, 1], [1, 0, 0, 1], [0, 0, 0, 1], [1, 1, 1, 0]]
n = len(a)
c = [-1] * n

nc = 0


def check_correct():
    for i in range(0, n):
        for j in range(0, n):
            if a[i][j] == 1 and c[i] == c[j] and c[i] != -1:
                return False
    return True


while True:
    c = [-1] * n
    nc += 1

    for i in range(0, n):
        for cc in range(0, nc):
            c[i] = cc
            if check_correct():
                break
    if check_correct():
        print(c)
        break
