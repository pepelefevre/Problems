
def nonAdjacentSum(arr):
    length = len(arr)
    sums = []
    sums.append(arr[length - 1])
    sums.append(max(arr[length - 1], arr[length - 2]))

    j = 2
    for i in reversed(range(0,len(arr)-2)):
        sums.append(max(arr[i]+sums[j-2], sums[j-1]))
        j = j + 1

    return sums.pop()

def nonAdjacentSum2(arr):
    length = len(arr)

    maxG = 0
    max1 = arr[length - 1]
    max2 = max(arr[length - 1], arr[length - 2])

    j = 2
    for i in reversed(range(0,len(arr)-2)):
        maxG = max(arr[i]+max1, max2)
        max1 = max2
        max2 = maxG
        j = j + 1

    return max2

list1 = [10,5,1,12,7,-5,0,10]
list2 = [5,1,1,5]

print(nonAdjacentSum(list1))
print(nonAdjacentSum2(list1))



