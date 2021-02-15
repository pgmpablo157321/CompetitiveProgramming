
string=""
for i in range(1001):
    string+=str(i)
print(string)
ans=0
for i in range(len(string)-1):
   if (string[i]=='8') and (string[i+1]=='9'):
       ans+=1

print(ans)