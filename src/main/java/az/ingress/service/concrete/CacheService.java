package az.ingress.service.concrete;

import az.ingress.model.CacheData;
import az.ingress.util.CacheUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class CacheService {
    private final CacheUtil cacheUtil;
    public void save(long id, String name){
        var cacheKey = "ms-employee:employeeId:"+id;
        var data = new CacheData(name);
        cacheUtil.saveToCache(cacheKey, data, 1L, ChronoUnit.MINUTES);
    }

    public CacheData get(String cacheKey){
        CacheData data = cacheUtil.getBucket(cacheKey);
        log.info("ActionLog.cacheData:{}",  data);
        return data;
    }


}
