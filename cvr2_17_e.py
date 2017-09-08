line_one = input()
details = line_one.split(',')
students = int(details[0])
cols = int(details[2])
rows = int(details[1])

line_two = input()
students_height = line_two.split(',')
students_height.sort(reverse=True)

des = []
n = 0
max_descrip = 0
while ((students - 1) - n) >= rows:
    diff = int(students_height[n]) - int(students_height[n + (cols - 1)])
    des.append(diff)
    if max_descrip < diff:
        max_descrip = diff
    n += cols
n -= cols
pivot = n + 1
diff = int(students_height[pivot]) - int(students_height[pivot + (cols - 1)])
if diff < max_descrip :
    des.pop()
    des.append(diff)
print(max(des))
