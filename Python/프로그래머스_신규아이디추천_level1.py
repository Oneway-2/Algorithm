def solution(new_id):
    allowed_text = ["-", "_", "."]

    # 1단계 소문자로 변경
    new_id = new_id.lower()

    # 2단계 허용되지 않은 문자 삭제
    tmp_list = list(new_id)
    for i in range(len(tmp_list)):
        if tmp_list[i] in allowed_text or "a" <= tmp_list[i] <= "z" or "0" <= tmp_list[i] <= "9":
            continue
        tmp_list[i] = ""
    new_id = "".join(tmp_list)

    # 3단계 연속점 없애기
    tmp_list = list(new_id)
    continued = False
    for i in range(len(tmp_list)):
        # 처음 . 발견
        if tmp_list[i] == "." and continued == False:
            continued = True
        # 연속된 . 발견
        elif tmp_list[i] == "." and continued == True:
            tmp_list[i] = ""
        # . 이 아님.
        else:
            continued = False
    new_id = "".join(tmp_list)
    tmp_list = list(new_id)

    # 4단계 양끝 마침표 제거
    if tmp_list[0] == ".":
        tmp_list[0] = ""
    if tmp_list[-1] == ".":
        tmp_list[-1] = ""
    new_id = "".join(tmp_list)

    # 5단계 빈 문자열이면 "a" 넣기
    if len(new_id) == 0:
        new_id = "a"

    # 6단계 16글자 이상일때 길이조절
    new_id = new_id[:15]
    if new_id[-1] == ".":
        new_id = new_id[:14]

    # 7단계 2글자 이하일때 길이조절
    while len(new_id) < 3:
        new_id = new_id + new_id[-1]

    return new_id
