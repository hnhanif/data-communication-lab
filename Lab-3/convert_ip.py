def deci_to_bin(num: int):
    binary = ""
    while num > 0:
        digit = str(num % 2)
        binary += digit
        num = num // 2
    return binary[::-1]


def bin_to_deci(num: str):
    decimal_list = []
    num = num[::-1]  # reverse
    for i in range(len(num)):
        portion = int(num[i]) * 2 ** i
        decimal_list.append(portion)

    return sum(decimal_list)


def ip_decimal_to_bin(ip_address: str):
    address = [int(_) for _ in ip_address.split(".")]
    ip_bin = ""
    for add in address:
        bin_digit = deci_to_bin(add)
        bin_len = len(bin_digit)
        while bin_len < 8:
            ip_bin += "0"
            bin_len += 1
        ip_bin += deci_to_bin(add)
        ip_bin += "."
    ip_bin = ip_bin[:-1]
    return ip_bin


def ip_binary_to_decimal(ip_address: str):
    address = ip_address.split(".")
    decimal_address = ""

    for add in address:
        digit = str(bin_to_deci(add))
        decimal_address += digit
        decimal_address += "."

    return decimal_address[:-1]


if __name__ == '__main__':
    result = ip_decimal_to_bin("205.55.91.243")
    print("bin_address: " + result)

    print("decimal_address: " + ip_binary_to_decimal(result))
