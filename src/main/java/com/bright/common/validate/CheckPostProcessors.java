package com.bright.common.validate;

/**
 * expand interface for bean check
 *
 * @author 33356
 * @since 2020/11/09
 */
public interface CheckPostProcessors {
    /**
     * Apply this CheckPostProcessors to the given new check instance <i>before</i> any check callbacks
     *
     * @return true if success
     */
    boolean postProcessBefore();

    /**
     * Apply this CheckPostProcessors to the given new check instance <i>after</i> any check callbacks
     *
     * @return true if success
     */
    boolean postProcessAfter();
}
