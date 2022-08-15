def solution(id_list, report, k):
    # 마지막에 reported_cnt 에서 k 횟수만큼 넘은 애의 이름을 빼다가 저장하고 (정지된 애들의 이름)
    # reporter_cnt 에서 걔낼 갖고있는지만 판단해준 뒤 횟수를 세면 될 듯.

    # 신고를 한 횟수
    reporter_cnt = dict()
    # 신고를 당한 횟수
    reported_cnt = dict()
    for i in id_list:
        reported_cnt[i] = 0
        reporter_cnt[i] = []

    # reported_cnt 에는 신고당한 횟수를 기록
    # reporter_cnt 에는 각각 아이디에 따른 신고자를 기록
    for report_text in report:
        reporter, reported = report_text.split()
        # 이미 같은 아이디로 같은 이용자를 신고한 적이 있으면 무시
        if reported in reporter_cnt[reporter]:
            continue
        reported_cnt[reported] += 1
        reporter_cnt[reporter].append(reported)

    # 정지된 아이디를 담을 배열
    suspended_id = []
    for i in reported_cnt:
        # print(i, reported_cnt[i])
        if reported_cnt[i] >= k:  # 정지 기준보다 많으면 넌 정지임
            suspended_id.append(i)

    # 몇개의 신고한 계정이 정지됐는지 세는 과정
    answer = []
    for i in id_list:
        cnt = 0
        for j in suspended_id:
            if j in reporter_cnt[i]:
                cnt += 1
        answer.append(cnt)

    return answer
