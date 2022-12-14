package org.apache.maven.shared.io.scan;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.maven.shared.io.scan.mapping.SourceMapping;

/**
 * @author <a href="mailto:trygvis@inamo.no">Trygve Laugst&oslash;l</a>
 * @version $Id: SimpleResourceInclusionScanner.java 1719477 2015-12-11 17:33:58Z khmarbaise $
 */
public class SimpleResourceInclusionScanner
    extends AbstractResourceInclusionScanner
{
    private Set<String> sourceIncludes;

    private Set<String> sourceExcludes;

    /**
     * @param sourceIncludes The source includes.
     * @param sourceExcludes The source excludes.
     */
    public SimpleResourceInclusionScanner( Set<String> sourceIncludes, Set<String> sourceExcludes )
    {
        this.sourceIncludes = sourceIncludes;

        this.sourceExcludes = sourceExcludes;
    }

    /** {@inheritDoc} */
    public Set getIncludedSources( File sourceDir, File targetDir )
        throws InclusionScanException
    {
        List<SourceMapping> srcMappings = getSourceMappings();

        if ( srcMappings.isEmpty() )
        {
            return Collections.<String>emptySet();
        }

        return Collections.singleton( scanForSources( sourceDir, sourceIncludes, sourceExcludes ) );
    }
}
