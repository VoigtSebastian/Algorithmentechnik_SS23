#! /usr/bin/env python3

# In case you don't have to return a string
# def binary(number):
#     if number > 0:
#         binary(number // 2)
#         print(number % 2, end="")


# Convert a decimal number to its binary representation as a string using divide and conquer with recursion
def binary(number):
    if number == 0:
        return "0"
    # Get rid of leading zero, depends on requirements
    if number == 1:
        return "1"
    return f"{binary(number // 2)}{number % 2}"
    # Without integer division a typecast is needed
    # return f"{binary(int(number / 2))}{number % 2}"


assert binary(0) == "0"
assert binary(1) == "1"
assert binary(7) == "111"
assert binary(10) == "1010"
assert binary(42) == "101010"
assert binary(100) == "1100100"
assert binary(256) == "100000000"
assert binary(512) == "1000000000"
assert binary(999) == "1111100111"
assert binary(1024) == "10000000000"
assert binary(2048) == "100000000000"
assert binary(4096) == "1000000000000"
assert binary(9876) == "10011010010100"
assert binary(65536) == "10000000000000000"
assert binary(1000000) == "11110100001001000000"

print("All tests passed!")
