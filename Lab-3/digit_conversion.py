def decimal_to_bin(num: int):
    binary = ""
    while num > 0:
        digit = str(num % 2)
        binary += digit
        num = num // 2
    return binary[::-1]


def bin_to_decimal(num: str):
    decimal_list = []
    num = num[::-1]  # reverse
    for i in range(len(num)):
        portion = int(num[i]) * 2 ** i
        decimal_list.append(portion)

    return sum(decimal_list)


if __name__ == '__main__':
    decimal_number = int(input("Enter Decimal number: "))
    binary_number = decimal_to_bin(decimal_number)
    print(f"Binary number is: {binary_number}")
    decimal_convert = bin_to_decimal(binary_number)
    print(f"Decimal number is : {decimal_convert}")
