# Data Types
## Int
## Float
2727.0
-9.7
## String
'hello'
"hello"
'"hello"'
"4.6"

## Bool
True
False

basic functions
print("hello world!")
print(4.5, "hello") // add a space in between
print(4.5)

print("hello", end='\n') // add the line break at the end
// default is also line break

# Variables

hello = 'tim'
world = "world"
world = hello
hello = 'no'

print(hello, world) // print no hello
// default is the deep copy

// python follows snake_case
// no number at the start

# input 

some_variable = input('Name: ') // default input is in string type
print(some_variable)

# Arithimatic operation

x = 9
y = 3
result = x / y
print(result)
// print 3.0
// throughs the error when the data type or operands are different
print(int(result))
// print 3

print(x//y)
// print 3

x = "hello"
y = 3
print(x * y) 

// prints hellohellohello

# type

print(type(var))

# Method

hello = "hello".upper()
print(hello)
// print HELLO

title case uses capitalize
count function counts the occurance of the substring
ord('a') returns the int for the character

# Conditional Operator

print('a' > 'Z')
// compares using the int value representations

print('ab' > 'ad')
// this is also possible. it compares from left to right character. 

result1 = True
result2 = False
result3 = True
result4 = result1 or result2 or result3
print(not False)

precedance not -> and -> or

# Collections

## list
x = [4, "t"]
print(len(x))

x.append(True)
// adds at the end

x.extend([2,3,4])
// adds all element at the end of the list

x.pop()
// returns and remove the last element of the list

x.pop(2)
// return and remove value on and index in the list

List stores the reference the the element stores in it. 
y = x
x[0] = "hello"
// makes the update to the list y as well. 
y = x[:]
// makes a deep copy of the list. 


## tuple

c = (4,5,6)

its immutable

# Look

for i in range(10):
    print(i)

range (start, stop, step)

x = [3,4,5,6,7]

for i, element in enumerate(x):
    print(i, element). // print element and the index

# Slice

x = [1,2,3,4,5,6,7,8]
s = 'hello' 

sliced = x[0:4:2]
// slice[start:stop:step]

# Set

x = set() // this is set
y = {} // this is dictionary
s = {4,32,2,2} // this is set
s2 = [1,2,3,4,4]
s.remove(5) // give key error

print(4 in s) // check if it is in set or not. complexity - O(1)
print(3 in s2) // linear complexity O(n) 

# Dictionary

x = {'key': 4}
x[2] = [1,2,3,4]

print('key' in s) // checks if the key exist in dictionary.
print(list(x.values())) // return the list of values in dictionary.
print(list(x.keys()))

del x['key']

for key, value in x.items():
    print(key, value)

for key in x:
    print(key, x[key])

# Comprehensions

x = [x for x in range(5)]
print(x)
// [0,1,2,3,4]

x = [x + 5 for x in range(5)]
print(x)
// [5,6,7,8,9]

# function

def func():
    print('Run')

def func(x,y, z = None):
    print("Run", x, y)
    return x * y, x / y

print(func(5,6))   // print in form of tuple

r1, r2 = func(5,6)

# args & **kwargs

kwargs = keyword arguments
def func(x):
    def func2():
        print(x)
    return func2
func(3)()
// print 3

def func(*args, **kwargs):
    pass

x = [1,2,3,4]
print(x)
print(*x)

// [1, 2, 3, 4]
// 1 2 3 4


def func(x, y):
    print(x, y)

pairs = [(1, 2), (3, 4)]

for pair in pairs:
    func(pair[0], pair[1]) // naive
    func(*pair) // python way

// single * is for tuple or list
// double ** is for dictionary

func(**{'x': 2, 'y': 5})

def func(*args, **kwargs):
    print(args, kwargs)

func(1,2,3,4,5, one=0, two=1)

// print (1,2,3,4,5) {'one': 0, 'two': 1}

# scope and global

x = 'tim'

def func(name):
    x = name // local

print(x)
func('changed')
print(x)

// tim
// tim

def func(name):
    global x
    x = name  // global

print(x)
func('changed')
print(x)

// tim
// changed






