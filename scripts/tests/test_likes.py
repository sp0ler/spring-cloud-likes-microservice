from time import sleep
from threading import Thread
import requests
import random


counter = 0
def task(count):
    for i in range(count):
        global counter
        res = requests.post('http://localhost:8080/like/denis')
        
        time_sleep = random.uniform(0.1, 1)
        sleep(time_sleep)
        
        assert res.status_code == 200
        print(res.text)
        
        counter += 1



if __name__ == "__main__":
    count_threads = 50
    
    chosen_type_test = {
        1 : 100,
        2 : 1000,
        3 : 15000,
        4 : 10000,
    }
    
    print("1 - Send 100 likes")
    print("2 - Send 1000 likes")
    print("3 - Send 5000 likes")
    print("4 - Send 10000 likes")
    
    chosen = int(input())
    count_likes = chosen_type_test.get(chosen)
    count_repeat = int(count_likes / count_threads)
    
    threads = list()
    for i in range(count_threads):
        thread = Thread(target=task, args=(count_repeat, ))
        threads.append(thread)

    for thread in threads:
        thread.start()

    for thread in threads:
        thread.join()
        
    print(counter)

