def solution(d, budget):
    d.sort()
    print(d)
    answer = 0
    idx = 0
    while True:
        if budget >= d[idx]:
            budget -= d[idx]
            answer += 1
            idx += 1
            if idx > len(d) - 1:
                break
        else:
            break

    return answer

# 요령: d를 오름차순으로 나열하면 앞에서부터는 작은 금액으로 정렬된다.
# budget 에서 하나씩 깎아나가다가, 더이상 남은 budget에서 물품을 사줄 수 없거나
# idx가 d의 길이를 넘어가버리면 break
