from time import sleep
from threading import Thread
import requests
import random

def task(count):
    for i in range(count):
        res = requests.get('http://localhost:8080/test')
        
        time_sleep = random.uniform(0.5, 5)
        sleep(time_sleep)
        
        assert res.status_code == 200
        print(res.text)



if __name__ == "__main__":
    count_threads = 200
    count_repeat = 300000
    
    threads = list()
    for i in range(count_threads):
        thread = Thread(target=task, args=(count_repeat, ))
        threads.append(thread)

    for thread in threads:
        thread.start()

    for thread in threads:
        thread.join()

