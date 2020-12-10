local current = redis.call('GET', KEYS[1])
if current then
    return false
else
    redis.call('SET', KEYS[1], ARGV[1])
    redis.call('EXPIRE', KEYS[1], ARGV[2])
    return true
end