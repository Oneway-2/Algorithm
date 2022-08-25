def getDistance(right, left, pos):
    rightDist = abs(right[0] - pos[0]) + abs(right[1] - pos[1])
    leftDist = abs(left[0] - pos[0]) + abs(left[1] - pos[1])
    return rightDist, leftDist
    
def solution(numbers, hand):
    answer = ""
    # 왼손가락, 오른손가락 위치
    left, right = [0,3], [2,3]
    for num in numbers:
        if num == 1:
            left = [0,0]
            answer += "L"
        elif num == 4:
            left = [0,1]
            answer += "L"
        elif num == 7:
            left = [0,2]
            answer += "L"
        elif num == 3:
            right = [2,0]
            answer += "R"
        elif num == 6:
            right = [2,1]
            answer += "R"
        elif num == 9:
            right = [2,2]
            answer += "R"
        elif num == 2:
            rightDist, leftDist = getDistance(right, left, [1,0])
            if rightDist > leftDist:
                answer += "L"
                left = [1,0]
            elif rightDist < leftDist:
                answer += "R"
                right = [1,0]
            else:
                if hand == "right":
                    answer += "R"
                    right = [1,0]
                else:
                    answer += "L"
                    left = [1,0]
        elif num == 5:
            rightDist, leftDist = getDistance(right, left, [1,1])
            if rightDist > leftDist:
                answer += "L"
                left = [1,1]
            elif rightDist < leftDist:
                answer += "R"
                right = [1,1]
            else:
                if hand == "right":
                    answer += "R"
                    right = [1,1]
                else:
                    answer += "L"
                    left = [1,1]
        elif num == 8:
            rightDist, leftDist = getDistance(right, left, [1,2])
            if rightDist > leftDist:
                answer += "L"
                left = [1,2]
            elif rightDist < leftDist:
                answer += "R"
                right = [1,2]
            else:
                if hand == "right":
                    answer += "R"
                    right = [1,2]
                else:
                    answer += "L"
                    left = [1,2]
        elif num == 0:
            rightDist, leftDist = getDistance(right, left, [1,3])
            if rightDist > leftDist:
                answer += "L"
                left = [1,3]
            elif rightDist < leftDist:
                answer += "R"
                right = [1,3]
            else:
                if hand == "right":
                    answer += "R"
                    right = [1,3]
                else:
                    answer += "L"
                    left = [1,3]       
                    
    return answer