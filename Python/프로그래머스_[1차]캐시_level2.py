def solution(cacheSize, cities):
    answer = 0
    cachebox = []

    if cacheSize == 0:
        answer = 5 * len(cities)
        return answer

    for city in cities:
        ref = city.lower()
        if ref in cachebox:
            answer += 1
            cachebox.append(cachebox.pop(cachebox.index(ref)))
        else:
            answer += 5
            if len(cachebox) != cacheSize:
                cachebox.append(ref)
            else:
                cachebox.pop(0)
                cachebox.append(ref)

    return answer


print(solution(3, ["Jeju", "Pangyo", "Seoul", "NewYork",
      "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]))
print(solution(3, ["Jeju", "Pangyo", "Seoul", "Jeju",
      "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]))
print(solution(2, ["a", "a", "a", "b", "b", "b", "c", "c", "c"]))
print(solution(3, ["A", "B", "A"]))

# LRU (Least Recently Used) 알고리즘을 활용하는 문제
# 반례가 있었는데 못찾아서 1시간동안 헤맸다.
