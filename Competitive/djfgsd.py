#Taking Inputs
herbi, carni, aqua = map(int, input().split())
areaH, areaC, areaA = map(int, input().split())
mh, mah = map(int, input().split())
mc, mac = map(int, input().split())
ma, maa = map(int, input().split())

ta = int(input())

//computing minimum
temp = min(herbi, carni, aqua)
if temp == herbi:
 a1 = areaH * temp
 x = areaH
elif temp == carni:
 a1 = areaC * temp
 x = areaC
else:
 a1 = areaA * temp
 x = areaA

//computing maximum
temp = max(herbi, carni, aqua)
if temp == herbi:
 a2 = mh * mah * herbi
 y = mh * mah
elif temp == carni:
 a2 = mc * mac * carni
 y = mc * mac
else:
 a2 = ma * maa * aqua
 y = ma * maa

//Append to the final list
z = ta - (x + y)
arr = []
arr.append(herbi)
arr.append(carni)
arr.append(aqua)
sor_arr = sorted(arr)
a3 = z * sor_arr[1]

print(a1 + a2 + a3 )