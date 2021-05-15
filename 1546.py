n = int(input())
scores = list(map(int, input().split()))
m = max(scores)
for i in range(len(scores)):
    scores[i] = scores[i]/m*100
av_scores = sum(scores)/n
print(av_scores)

# 백준은 numpy 라이브러리를 지원하지 않는걸 몰랐다.